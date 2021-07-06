const redirectWait = 700;

function toggleThreadTmpl(path, method, showTitle=true) {
    let threadContainer = $('#thread-container');
    let threadCreator = $('#thread-creator');

    let threadCreatorTitle = $('.thread-creator-title');
    if (showTitle) threadCreatorTitle.show();
    else threadCreatorTitle.hide();

    let threadForm = $('#thread-creator > form');
    threadForm.attr("action", path);

    let threadMethod = $('#method');
    threadMethod.attr("value", method);

    if (threadContainer.is(':visible')) {
        threadContainer.hide();
        threadCreator.show();
    } else {
        threadContainer.show();
        threadCreator.hide();
    }
}

function toggleCommentTmpl(thread_id) {
    let commentCreator = $('#comment-creator-' + thread_id);

    if (commentCreator.is(':visible')) {
        commentCreator.hide();
    } else {
        commentCreator.show();
    }
}

async function redirect(path) {
    await new Promise(r => setTimeout(r, redirectWait));
    window.location.href = path;
}

function request(url, method) {
    $.ajax({
        url: url,
        type: method,
    }).done(async function (response) {
        msg(response.msg);
        await new Promise(r => setTimeout(r, redirectWait));
        if (response.loggedIn === false) {
            window.location.href = "/user/login";
        } else if (response.res === true){
            window.location.reload();
        }
    });
}

function ask(msg, func){
    if (confirm(msg)) {
        func();
    }
}

function msg(msg=""){
    if (msg!==""){
        window.scrollTo(0, 0);
    }
    $('#msg').text(msg);
}
