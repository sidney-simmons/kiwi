$(document).ready(function() {
    // Pull the server's environment data
    $.get("/environment/get-environment", function(data, status) {
        $("footer .footer-version").html("<div>Application version: " + data.implementationVersion + "</div><div>Node: " + data.hostName + "</div>");
    });
});

/**
 * Trigger a google analytics event with the given category, action, and label.
 * 
 * @param category a category
 * @param action an action
 * @param label a label
 */
function triggerGoogleAnalyticsEvent(category, action, label) {
    gtag("event", action, {
        "event_category" : category,
        "event_label" : label
    });
}