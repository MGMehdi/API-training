import React from 'react'
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ViewClient from './ViewClient'

export default function Caca() {
    return (
        <div>
            <Router>
                <Switch>
                    <Route path="/api/client/mail" component={ViewClient}></Route>
                </Switch>
            </Router>
        </div>
    )
}
