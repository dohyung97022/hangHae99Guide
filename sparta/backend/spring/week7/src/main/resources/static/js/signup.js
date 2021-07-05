function validateForm() {
    const formMsg = $(`#form-msg`);

    const username = ($(`#username`).val());
    const idRegex = new RegExp('[a-zA-Z0-9]{3,}');
    const idFound = idRegex.test(username);
    if (!idFound){
        formMsg.text("username 이 정규식 [a-zA-Z0-9]{3,} 을 따르지 않습니다.");
        return false;
    }

    const password = ($(`#password`).val());
    const pwRegex = new RegExp('.{4,}');
    const pwFound = pwRegex.test(password);
    if (!pwFound){
        formMsg.text("password 가 정규식 .{4,} 을 따르지 않습니다.");
        return false;
    }

    const containsRegex = new RegExp("^.*"+username+".*$");
    const pwContainsFound = containsRegex.test(password);
    if (pwContainsFound){
        formMsg.text("username 가 password 에 포함되어 있습니다.");
        return false;
    }

    return true;
}