import React from "react";
import { createRoot } from 'react-dom/client';

import makeServer from './server'


import App from "./App";

makeServer();

const container = document.getElementById('root');
const root = createRoot(container);
root.render(<App />);
