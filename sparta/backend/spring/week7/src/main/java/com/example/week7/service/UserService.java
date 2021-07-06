package com.example.week7.service;

import com.example.week7.domain.User;
import com.example.week7.domain.UserRole;
import com.example.week7.dto.SignupRequestDto;
import com.example.week7.repository.UserRepository;
import com.example.week7.security.UserDetailsImpl;
import com.example.week7.security.kakao.KakaoOAuth2;
import com.example.week7.security.kakao.KakaoUserInfo;
import com.example.week7.tools.RegexChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

@Service
public class UserService {
    private PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final KakaoOAuth2 kakaoOAuth2;
    private final AuthenticationManager authenticationManager;
    private static final String ADMIN_TOKEN = "AAABnv/xRVklrnYxKZ0aHgTBcXukeZygoC";

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, KakaoOAuth2 kakaoOAuth2, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.kakaoOAuth2 = kakaoOAuth2;
        this.authenticationManager = authenticationManager;
    }

    public void registerUser(@NotNull SignupRequestDto requestDto) {
        String username = requestDto.getUsername();
        // 회원 ID 중복 확인
        Optional<User> found = userRepository.findByUsername(username);
        if (found.isPresent()) {
            throw new IllegalArgumentException("중복된 사용자 ID 가 존재합니다.");
        }
        // 아이디 regex 확인
        if (!RegexChecker.check(username, RegexChecker.idRegex)){
            throw new IllegalArgumentException("아이디는 3자 이상의 영문, 숫자 조합이여야 합니다.");
        }

        // 패스워드 확인
        if (!RegexChecker.check(requestDto.getPassword(), RegexChecker.pwRegex)){
            throw new IllegalArgumentException("비밀번호는 4자 이상이여야 합니다.");
        }
        // 아이디가 패스워드에 포함되었는지 확인
        String containsRegex = RegexChecker.getContainsRegex(username);
        if (RegexChecker.check(requestDto.getPassword(), RegexChecker.getContainsRegex(username))){
            throw new IllegalArgumentException("아아디가 비밀번호에 포함되어 있습니다.");
        }
        // 패스워드 인코딩
        String password = passwordEncoder.encode(requestDto.getPassword());

        User user = new User(username, password, UserRole.USER);
        userRepository.save(user);
    }

    public void kakaoLogin(String authorizedCode) {
        // 카카오 OAuth2 를 통해 카카오 사용자 정보 조회
        KakaoUserInfo userInfo = kakaoOAuth2.getUserInfo(authorizedCode);
        Long kakaoId = userInfo.getId();
        String nickname = userInfo.getNickname();

        // 우리 DB 에서 회원 Id 와 패스워드
        // 회원 Id = 카카오 nickname
        String username = nickname;
        // 패스워드 = 카카오 Id + ADMIN TOKEN
        String password = kakaoId + ADMIN_TOKEN;

        // DB 에 중복된 이메일이 있는지 확인

        // DB 에 중복된 Kakao Id 가 있는지 확인
        User sameKakaoUser = userRepository.findByKakaoId(kakaoId).orElse(null);

        // 최종적으로 사용할 User
        User finalUser = null;

        // 카카오 중복

        // 1. 카카오 중복이 있을 경우 - > 그냥 그 카카오로 로그인
        if (sameKakaoUser != null) {
            finalUser = sameKakaoUser;
        }
        // 2. 카카오 중복이 없을 경우 -> 신규 회원가입
        else if (sameKakaoUser == null) {
            String encodedPassword = passwordEncoder.encode(password);
            // ROLE = 사용자
            UserRole role = UserRole.USER;

            finalUser = new User(nickname, encodedPassword, role, kakaoId);
            userRepository.save(finalUser);
        }

        // finalUser 로그인 처리
        UserDetailsImpl userDetails = new UserDetailsImpl(finalUser);
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }
}