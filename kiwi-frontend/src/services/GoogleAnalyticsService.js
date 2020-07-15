export default new (class {
    /**
     * Trigger a google analytics event with the given category, action, and label.
     *
     * @param category a category
     * @param action an action
     * @param label a label
     */
    triggerGoogleAnalyticsEvent(category, action, label) {
        gtag("event", action, {
            event_category: category,
            event_label: label,
        });
    }
})();
