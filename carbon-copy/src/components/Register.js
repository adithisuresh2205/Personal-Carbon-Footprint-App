import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const Register = () => {
    const [user, setUser] = useState({ username: '', password: '', email: '' });
    const navigate = useNavigate();

    const handleInputChange = (e) => {
        setUser({ ...user, [e.target.name]: e.target.value });
    };

    const handleRegister = async (e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/auth/register', user);
            alert("Registration Successful! Please login.");
            navigate('/');
        } catch (error) {
            alert("Registration Failed. Ensure the backend is running.");
        }
    };

    return (
        <div style={{ padding: '40px', textAlign: 'center' }}>
            <h2>Create Account</h2>
            <form onSubmit={handleRegister} style={{ display: 'inline-block', textAlign: 'left' }}>
                <label>Username:</label>
                <input type="text" name="username" onChange={handleInputChange} style={{ display: 'block', marginBottom: '10px' }} required />
                <label>Email:</label>
                <input type="email" name="email" onChange={handleInputChange} style={{ display: 'block', marginBottom: '10px' }} required />
                <label>Password:</label>
                <input type="password" name="password" onChange={handleInputChange} style={{ display: 'block', marginBottom: '10px' }} required />
                <button type="submit">Sign Up</button>
            </form>
        </div>
    );
};

export default Register;