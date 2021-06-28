// 로딩이 완료되면 해당 메모를 로딩합니다.
$(document).ready(function () {
    let memoId = window.location.pathname.split("/").pop();
    $.ajax({
        type: "GET",
        url: `/api/memos/${memoId}`,
        success:
            function (response) {
                const memoHTML = `
                <div class = "write-item">
                    <div class="title item">
                        <p>제목</p> <p>${response.title}</p>
                    </div>
                    <div class="created-by item">
                        <p>작성자명</p> <p>${response.createdBy}</p>
                    </div>
                    <div class="contents item">
                        <p>내용</p> <p class="contents-text">${response.content}</p>
                    </div>
                </div>
                `
                $('.write-container').append(memoHTML);
            }
    })
});