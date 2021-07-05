function createThreadTmpl(){
    let threadContainer = $('#thread-container');
    let threadCreator = $('#thread-creator');

    if (threadContainer.is(':visible')){
        threadContainer.hide();
        threadCreator.show();
    } else {
        threadContainer.show();
        threadCreator.hide();
    }
}

async function redirect(path, msg) {
    $('#msg').text(msg);
    window.scrollTo(0,0);
    await new Promise(r => setTimeout(r, 2000));
    window.location.href = path;
}