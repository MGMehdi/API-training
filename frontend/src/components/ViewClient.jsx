import React, { Component } from 'react'
import GetClient from './../services/GetClient.js'

export class ViewClient extends Component {

    constructor(props) {
        super(props)

        this.state = {
            client: []
        }
    }

    render() {
        return (
            <div>
                <h1>ViewClient</h1>
                <button onClick={this.getClient}>CLICK</button>
                {
                    this.state.client.map(
                        c =>
                    <h2>{c.name}</h2>
                    )
                }

            </div>
        )
    }

    getClient = () => {
        let mail = "tutu@tutu"
        GetClient.getOneClient(mail).then(
            response => {
                this.state({
                    client: response.data
                })
            }
        )
    }
}

export default ViewClient
