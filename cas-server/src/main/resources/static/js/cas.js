
head.ready(document, function() {
    if (!window.jQuery) {
        head.load("https://cdn.bootcss.com/jquery/1.11.3/jquery.min.js", loadjQueryUI);
    } else {
        resourceLoadedSuccessfully();
    }
});

function loadjQueryUI() {
    head.load("https://cdn.bootcss.com/jqueryui/1.11.4/jquery-ui.min.js", loadjQueryCookies);
}

function loadjQueryCookies() {
    head.load("https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js", resourceLoadedSuccessfully);
}

function areCookiesEnabled() {
    if ($.cookie == undefined) {
        console.log("JQuery Cookie library is not defined")
        return;
    }
    
    $.cookie('cookiesEnabled', 'true');
    var value = $.cookie('cookiesEnabled');
    if (value != undefined) {
        $.removeCookie('cookiesEnabled');
        return true;
    }
    return false;
}

function resourceLoadedSuccessfully() {
    $(document).ready(function() {

        if ($(":focus").length === 0){
            $("input:visible:enabled:first").focus();
        }


        if (areCookiesEnabled()) {
            $('#cookiesDisabled').hide();
        } else {
            $('#cookiesDisabled').show();
            $('#cookiesDisabled').animate({ backgroundColor: 'rgb(187,0,0)' }, 30).animate({ backgroundColor: 'rgb(255,238,221)' }, 500);
        }

        //flash error box
        $('#msg.errors').animate({ backgroundColor: 'rgb(187,0,0)' }, 30).animate({ backgroundColor: 'rgb(255,238,221)' }, 500);

        //flash success box
        $('#msg.success').animate({ backgroundColor: 'rgb(51,204,0)' }, 30).animate({ backgroundColor: 'rgb(221,255,170)' }, 500);

        //flash confirm box
        $('#msg.question').animate({ backgroundColor: 'rgb(51,204,0)' }, 30).animate({ backgroundColor: 'rgb(221,255,170)' }, 500);

        $('#capslock-on').hide();
        $('#password').keypress(function(e) {
            var s = String.fromCharCode( e.which );
            if ( s.toUpperCase() === s && s.toLowerCase() !== s && !e.shiftKey ) {
                $('#capslock-on').show();
            } else {
                $('#capslock-on').hide();
            }
        });
        if (typeof(jqueryReady) == "function") {
            jqueryReady();
        }
    });

};
