import Axios from "axios";

export default new (class {
    getRepositories() {
        return Axios.get("/software-engineer/get-repositories").then((response) => {
            return response;
        });
    }
})();
