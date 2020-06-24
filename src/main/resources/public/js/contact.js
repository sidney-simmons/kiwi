$(document).ready(function() {
    // Create GA event when a contact link is clicked
    $(".js-contact-link").click(function() {
        triggerGoogleAnalyticsEvent("links", "contact-link-clicked", $(this).attr("href"));
    });
});