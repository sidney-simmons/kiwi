import Axios from 'axios'

export default new class {
    getEnvironment() {
        return Axios.get('/environment/get-environment').then(response => {
            return response;
        }); 
    }
}