import React from 'react';
import ReactDOM from 'react-dom';
import App from './App.tsx';
import './index.css';
import { BrowserRouter } from 'react-router-dom';
import { QueryClient, QueryClientProvider } from 'react-query'


const queryClient = new QueryClient({
  defaultOptions: {
    queries: {
      retry: 1,
    },
  },
 });
 

ReactDOM.render(
  <React.StrictMode>
       <QueryClientProvider client={queryClient}>

    <BrowserRouter>
      <App />
    </BrowserRouter>
    </QueryClientProvider>

  </React.StrictMode>,
  document.getElementById('root')
);
