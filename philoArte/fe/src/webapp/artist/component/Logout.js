import React from 'react';
import { useHistory } from 'react-router';

const Logout = () => {
    const history = useHistory();

    const logoutButton = (e) => {
        e.preventDefault();
        e.stopPropagation();
        localStorage.clear(e);
        history.push('/');
    };

    return (
        <>
            <button
                className="buttonSelectList2"
                onClick={(e) => {
                    logoutButton(e);
                }}
            >
                ๋ก๊ทธ์์
            </button>
        </>
    );
};
export default Logout;
