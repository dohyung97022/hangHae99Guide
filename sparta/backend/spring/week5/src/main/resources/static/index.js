// 로딩이 완료되면 메모들을 로드합니다.
$(document).ready(function () {
    $.ajax({
        type: "GET",
        url: "/api/memos",
        success:
            function (response) {
                for (let i = 0; i < response.length; i++) {
                    let memo = response[i];
                    // memo.createdAt
                    // memo.createdBy
                    // memo.modifiedAt
                    // memo.title
                    let date = new Date(memo.modifiedAt).toLocaleString("en-US");
                    let HTMLTemplate = `
                    <div class="flex-grid-item" onclick="redirectToInspectMemo(${memo.id})">
                        <div class="item-title">${memo.title}</div>
                        <div class="item-writer-datetime">
                            <div class="item-writer">${memo.createdBy}</div>
                            <div class="item-datetime">${date}</div>
                        </div>
                    </div>
                    `
                    $('.flex-grid').append(HTMLTemplate);
                }
                let FakeHTMLTemplate = `<div class="flex-grid-item"/>`
                for (let i = 0; i < 10; i++) {
                    $('.flex-grid').append(FakeHTMLTemplate);
                }
            }
    })
});