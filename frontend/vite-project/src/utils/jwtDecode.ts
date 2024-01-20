import {jwtDecode} from 'jwt-decode'; // Make sure this is the default import, not { jwtDecode }


interface JwtPayload {
    userType: string;
    userId: string;
    username: string; // Add this line if your token contains the username
    iat: number;
    exp: number;
}

export const decodeToken = (token: string): JwtPayload | null => {
    try {
        const decodedToken = jwtDecode<JwtPayload>(token);
        return decodedToken;
    } catch (error) {
        console.error('Error decoding token:', error);
        return null;
    }
};
