import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';
import ExitToAppIcon from '@mui/icons-material/ExitToApp';

import { AppBar } from './style';
import { useAuth } from 'hooks/useAuth';


const Header = () => {

  const { logoff } = useAuth();

  const handleLogoff = () => {
    logoff();
  }


    return (
        <AppBar>
          <Toolbar>
            <Typography
              component="h1"
              variant="h6"
              color="inherit"
              noWrap
              sx={{ flexGrow: 1 }}
            >
              Área administrativa
            </Typography>
            <IconButton color="inherit" onClick={handleLogoff}>
                <ExitToAppIcon />
            </IconButton>
          </Toolbar>
        </AppBar>
    )
}

export { Header }