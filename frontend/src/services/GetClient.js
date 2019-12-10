import axios from 'axios'

class GetClient {
    getOneClient(mail) {
        return axios.get(`/api/client/mail/${mail}`)
    }
}

export default new GetClient()