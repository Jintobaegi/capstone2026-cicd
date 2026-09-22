// 백엔드 API 기본 주소
const API_BASE_URL = "http://localhost:8082/api/members";

/**
 * 1. 회원가입 함수 (POST /api/members/register)
 */
async function handleRegister() {
    const userId = document.getElementById('regUserId').value;
    const password = document.getElementById('regPassword').value;
    const name = document.getElementById('regName').value;

    const memberData = {
        userId: userId,
        password: password,
        name: name
    };

    try {
        const response = await fetch(`${API_BASE_URL}/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(memberData)
        });

        if (response.ok) {
            alert("회원가입 성공!");
        } else {
            const msg = await response.text();
            alert("실패: " + msg);
        }
    } catch (error) {
        console.error("통신 에러:", error);
    }
}

/**
 * 2. 로그인 함수 (POST /api/members/login)
 */
async function handleLogin() {
    const userId = document.getElementById('userId').value;
    const password = document.getElementById('password').value;

    const loginData = {
        userId: userId,
        password: password
    };

    try {
        const response = await fetch(`${API_BASE_URL}/login`, {
            method: 'POST', // REST 규약에 따라 본문에 데이터를 담기 위해 POST 사용
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(loginData)
        });

        if (response.ok) {
            const user = await response.json();
            alert(`${user.name}님, 환영합니다!`);
            console.log("로그인 유저 정보:", user);
        } else {
            alert("로그인 실패: 아이디 또는 비밀번호를 확인하세요.");
        }
    } catch (error) {
        console.error("통신 에러:", error);
    }
}