import axios from 'axios'

class GetClient {
    getOneClient(mail) {
        return axios.get(`http://localhost:8080/api/client/mail/${mail}`)
    }
}

export default new GetClient()