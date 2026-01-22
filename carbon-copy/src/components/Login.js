import React, { useState } from 'react';
import axios from 'axios';

const Login = () => {
    const [credentials, setCredentials] = useState({ username: '', password: '' });

    const handleChange = (e) => {
        setCredentials({ ...credentials, [e.target.name]: e.target.value });
    };

    const handleLogin = async (e) => {
        e.preventDefault();
        try {
            const response = await axios.post('http://localhost:8080/auth/login', credentials);
            // This saves the JWT token you saw in Postman to the browser
            localStorage.setItem('token', response.data.jwt);
            alert("Login Successful!");
            window.location.href = '/dashboard';
        } catch (error) {
            alert("Invalid Credentials");
        }
    };

    return (
        <div style={{ padding: '20px', maxWidth: '400px' }}>
            <h2>Login to Carbon Tracker</h2>
            <form onSubmit={handleLogin}>
                <input name="username" placeholder="Username" onChange={handleChange} style={{display: 'block', margin: '10px 0'}} />
                <input name="password" type="password" placeholder="Password" onChange={handleChange} style={{display: 'block', margin: '10px 0'}} />
                <button type="submit">Login</button>
            </form>
        </div>
    );
};

export default Login;