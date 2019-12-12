import axios from 'axios'

//On peut aussi travaillé sous forme de service

class GetClient {

    getOneClient(mail) {
        return axios.get(`http://localhost:8080/api/client/mail/${mail}`)
    }
}

export default new GetClient()