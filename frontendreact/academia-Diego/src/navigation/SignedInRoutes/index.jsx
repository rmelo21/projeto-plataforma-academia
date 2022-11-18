import React from "react";
import {
  Routes,
  Route,
  Navigate,
} from "react-router-dom";
import MainLayout from 'components/Layout';


import { Dashboard } from 'pages/SignedIn/Dashboard'

import { ListClient } from 'pages/SignedIn/ListClient'
import { NewClient } from 'pages/SignedIn/NewClient'

import { ListCollaborators } from 'pages/SignedIn/ListCollaborators'
import { NewCollaborator } from 'pages/SignedIn/NewCollaborator'

import { ListFinancial } from 'pages/SignedIn/ListFinancial'

function SignedInRoutes() {
  return (
      <MainLayout>
        <Routes>
          <Route index path="/" element={<Dashboard />} />
          
          <Route path="/client-list" element={<ListClient />} />
          <Route path="/client-new" element={<NewClient />} />

          <Route path="/collaborators-list" element={<ListCollaborators />} />
          <Route path="/collaborator-new" element={<NewCollaborator />} />

          <Route path="/financial-list" element={<ListFinancial />} />
          
          <Route
            path="*"
            element={<Navigate to="/" replace />}
         />
        </Routes>
      </MainLayout>
  )
}

export default SignedInRoutes