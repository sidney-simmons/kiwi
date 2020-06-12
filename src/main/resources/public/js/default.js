$(document).ready(function() {
    // Pull the server's environment data
    $.get("/environment/get-environment", function(data, status) {
        $("footer .footer-version").html("<div>Application version: " + data.implementationVersion + "</div><div>Node: " + data.hostName + "</div>");
    });
});
