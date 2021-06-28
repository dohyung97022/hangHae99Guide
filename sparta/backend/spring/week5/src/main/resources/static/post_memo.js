function post_memo(){
    $.ajax({
        type: "POST",
        url: `/api/memos/`,
        contentType: "application/json",
        data : JSON.stringify({
            'title' : $('.title input').val(),
            'createdBy': $('.created-by input').val(),
            'content' : $('.contents input').val()
        }),
        success:
            function (response) {
                alert("메모가 작성되었습니다.");
                window.location.href = "/";
            }
    })
}