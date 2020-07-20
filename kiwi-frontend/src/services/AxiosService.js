import Axios from "axios";
import GoogleAnalyticsService from "@/services/GoogleAnalyticsService";

Axios.interceptors.response.use(
    function (response) {
        // All happy 2XX responses - return the response
        return response;
    },
    function (error) {
        // All other sad responses - send a google analytics event and return the error
        try {
            let responsePath = error.response.data.path;
            let responseStatus = error.response.data.status;
            if (responsePath && responseStatus) {
                GoogleAnalyticsService.triggerGoogleAnalyticsEvent("errors", "ajax-response-error", responsePath + " - " + responseStatus);
            }
        } catch (tryCatchError) {
            // Nothing to do here
        }
        return Promise.reject(error);
    }
);

export default Axios;
