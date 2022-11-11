import Navigation from "navigation";
import CssBaseline from '@mui/material/CssBaseline';
import { AuthProviver } from 'context/authContext';
import { createTheme, ThemeProvider } from '@mui/material/styles';

import { ToastContainer } from 'react-toastify';
  
import 'react-toastify/dist/ReactToastify.css';
import '@fontsource/roboto/300.css';
import '@fontsource/roboto/400.css';
import '@fontsource/roboto/500.css';
import '@fontsource/roboto/700.css';

const theme = createTheme();

function App() {
  return (
      <AuthProviver >
        <ThemeProvider theme={theme}>
          <CssBaseline />
          <ToastContainer 
            position="bottom-center"
            autoClose={5000}
            hideProgressBar={false}
            newestOnTop={false}
            closeOnClick
            rtl={false}
            pauseOnFocusLoss
            draggable
            pauseOnHover
            theme="light"
          />
          <Navigation />
        </ThemeProvider>
      </AuthProviver>
  )
}

export default App