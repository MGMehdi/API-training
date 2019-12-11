import Axios from 'axios'
import React, { Component } from 'react'

export class ViewClient extends Component {

    constructor(props) {
        super(props)

        this.state = {
            client: null,
            mail: "toto@toto",
            name: ""
        }
    }

    componentDidMount()
    {
        

        Axios.get(`http://localhost:8080/api/client/mail/${this.state.mail}`)
        .then((res) => {
            console.log(res.data)
            this.setState({client: res.data})
            this.setState({name: res.data._name})
        }).catch(err => console.log(err))
    }

   
    render() {
        
        return (
            <div>
                <h1>ViewClient</h1>
        <h2>{this.state.name}</h2>
       

            </div>
        )
    }

    
}

export default ViewClient
