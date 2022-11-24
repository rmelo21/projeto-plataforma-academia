import React from "react";
import {
  Routes,
  Route,
  Navigate,
} from "react-router-dom";

import Login from 'pages/SignIn/Login'
import Signup from 'pages/SignIn/Signup'

function SignInRoutes() {
  return (
      <Routes>
         <Route index path="/" element={<Login />} />
         <Route path="/signup" element={<Signup />} />
         <Route
            path="*"
            element={<Navigate to="/" replace />}
         />
      </Routes>
  )
}

export default SignInRoutes