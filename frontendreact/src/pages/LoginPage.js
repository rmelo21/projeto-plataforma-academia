import React from 'react';
import { Button } from "reactstrap";

class LoginPage extends React.Component {
    render() {
        return (
            <div className="mainItem">
                <div className="subItem">
                    <div>
                        <div className="images">
                            <div className="containerImage">
                                {/* <img src={profilePicture} alt="profilePicture" className="profilePicture" /> */}
                            </div>
                        </div>
                        <div>
                            <h1>Bem-vindo!</h1>
                            <div className="emailInput">
                                {/* <img src={emailPicture} alt="emailLogo" className="emailLogo" /> */}
                                <input type="text" placeholder="Seu nome/email" className="emailItem" />
                            </div>
                            <div className="passwordInput">
                                {/* <img src={passwordPicture} alt="passwordLogo" className="passwordLogo" /> */}
                                <input type="password" placeholder="Sua senha" className="passwordItem" />
                            </div>
                            <div className="loginButton">
                                <Button color="primary">Login</Button>
                            </div>
                            <p className="passwordResetOrSignUpLink">
                                <a href="#">Esqueceu a sua senha?</a>
                                <br />
                                <a href="#">Cadastrar-se</a>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default LoginPage;