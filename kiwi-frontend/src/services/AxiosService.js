import Axios from "axios";

Axios.interceptors.response.use(
    function (response) {
        // All happy 2XX responses
        return response;
    },
    function (error) {
        // All other sad responses
        return Promise.reject(error);
    }
);

export default Axios;
