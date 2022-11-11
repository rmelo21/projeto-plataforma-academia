import React from "react";
import {
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import MainLayout from 'components/Layout';


import { Dashboard } from 'pages/SignedIn/Dashboard'

import { ListUsers } from 'pages/SignedIn/ListUsers'
import { NewUser } from 'pages/SignedIn/NewUser'

import { ListCollaborators } from 'pages/SignedIn/ListCollaborators'
import { NewCollaborator } from 'pages/SignedIn/NewCollaborator'

function SignedInRoutes() {
  return (
      <MainLayout>
        <Routes>
          <Route index path="/" element={<Dashboard />} />
          
          <Route path="/user-list" element={<ListUsers />} />
          <Route path="/user-new" element={<NewUser />} />

          <Route path="/collaborators-list" element={<ListCollaborators />} />
          <Route path="/collaborator-new" element={<NewCollaborator />} />
          <Route
            path="*"
            element={<Navigate to="/" replace />}
         />
        </Routes>
      </MainLayout>
  )
}

export default SignedInRoutes