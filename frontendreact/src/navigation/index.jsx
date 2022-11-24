import React from "react";
import {
  BrowserRouter,
} from "react-router-dom";

import SignedInRoutes from 'navigation/SignedInRoutes';
import SignInRoutes from "./SignInRoutes";
import { useAuth } from "hooks/useAuth";

function Navigation() {

  const { isLogged } = useAuth();
  return (
    <BrowserRouter>
       {isLogged ? <SignedInRoutes /> : <SignInRoutes />}  
    </BrowserRouter>
  )
}

export default Navigation