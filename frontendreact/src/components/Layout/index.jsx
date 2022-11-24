import Box from '@mui/material/Box';

import { Header } from './Header';
import { Menu } from './Menu';


const MainLayout = ({children}) => {

    return (
        <Box sx={{ display: 'flex' }}>
            <Box>
                <Menu />
            </Box>
            <Box component="main" sx={{ display: 'flex', flex:1, width: '100%' }} >
                <Header />
                <Box px={2} sx={{ display: 'flex', flex:1, width: '100%',  marginTop:'90px'}}>
                    {children}
                </Box>
            </Box>
        </Box>
    );
};

export default MainLayout;
