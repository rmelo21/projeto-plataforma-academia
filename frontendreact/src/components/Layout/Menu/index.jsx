import * as React from 'react';
import Toolbar from '@mui/material/Toolbar';
import List from '@mui/material/List';
import Divider from '@mui/material/Divider';
import ListItem from '@mui/material/ListItem';
import ListItemButton from '@mui/material/ListItemButton';
import ListItemIcon from '@mui/material/ListItemIcon';
import ListItemText from '@mui/material/ListItemText';

import { menuList } from './menuList';
import { Drawer } from './styles';

import logo from 'assets/images/logo.png'
import { useNavigate  } from 'react-router-dom';


const Menu = () => {

  const navigate = useNavigate();

  const handleGoToPage = (url)=> () => {
    navigate(url)
  }

  
    return (
         <Drawer variant="permanent">
          <Toolbar
            sx={{
              display: 'flex',
              alignItems: 'center',
              justifyContent: 'center',
              px: [1],
            }}
          >
            <img alt="logo academia" style={{cursor: 'pointer'}} onClick={handleGoToPage('/')} src={logo} width="180px" height="40px" />
          </Toolbar>
          <Divider />
          <List component="nav">
          <List>
        {menuList.map((menu, index) => (
          <ListItem key={index} disablePadding>
            <ListItemButton onClick={handleGoToPage(menu.link)}>
              <ListItemIcon>
                {menu.icon}
              </ListItemIcon>
              <ListItemText primary={menu.label} />
            </ListItemButton>
          </ListItem>
        ))}
      </List>
          </List>
        </Drawer>
        )
}

export { Menu } 