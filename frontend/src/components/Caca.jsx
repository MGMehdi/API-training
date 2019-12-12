import React from 'react'
import {BrowserRouter as Router, Route, Switch } from 'react-router-dom';
import ViewClient from './ViewClient'

// C'est la classe Router, mais "Router" est déjà pris, d'où le nom. Elle appelle le component en fonction du lien

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
