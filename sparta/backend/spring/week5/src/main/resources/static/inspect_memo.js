// 로딩이 완료되면 해당 메모를 로딩합니다.
$(document).ready(function () {
    let memoId = window.location.pathname.split("/").pop();
    $.ajax({
        type: "GET",
        url: `/api/memos/${memoId}`,
        success:
            function (response) {
                console.log(response);
            }
    })
});