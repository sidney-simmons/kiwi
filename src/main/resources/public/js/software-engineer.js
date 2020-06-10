$(document).ready(function() {
    // Change the repository "updated at" dates to local time and display in a "5 days ago" format
    $(".js-repository-updated-at").each(function() {
        let updatedAtUtcString = $(this).data("updated-at");
        let updatedAtDate = moment(updatedAtUtcString);
        $(this).text("Last updated " + updatedAtDate.fromNow());
    });
});