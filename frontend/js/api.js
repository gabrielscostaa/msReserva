const API_BASE_URL = 'http://127.0.0.1:8081/api';

const API = {
    usuarios: `${API_BASE_URL}/usuarios`,
    salas: `${API_BASE_URL}/salas`,
    reservas: `${API_BASE_URL}/reservas`
};

async function fetchData(url, options = {}) {
    try {
        console.log('Fazendo requisição para:', url, 'com opções:', options);
        
        const defaultHeaders = {
            'Content-Type': 'application/json',
            'Accept': 'application/json'
        };
        
        const response = await fetch(url, {
            ...options,
            headers: {
                ...defaultHeaders,
                ...options.headers
            }
        });

        console.log('Resposta recebida:', response.status, response.statusText);

        if (!response.ok) {
            const errorData = await response.json().catch(() => ({ message: response.statusText }));
            throw new Error(`Erro ${response.status}: ${errorData.message || JSON.stringify(errorData)}`);
        }

        if (response.status === 204) return null;
        
        const data = await response.json();
        console.log('Dados recebidos:', data);
        return data;
    } catch (error) {
        console.error('Falha na requisição:', error);
        UI.showToast(error.message, 'error');
        return undefined;
    }
}

// Funções de Usuário
async function listarUsuarios() {
    return fetchData(API.usuarios);
}

async function criarUsuario(usuario) {
    // Garante que a data está no formato correto
    const usuarioFormatado = {
        ...usuario,
        dataNascimento: new Date(usuario.dataNascimento).toISOString().split('T')[0]
    };
    console.log('Dados do usuário formatados:', usuarioFormatado);
    
    return fetchData(API.usuarios, {
        method: 'POST',
        body: JSON.stringify(usuarioFormatado)
    });
}

// Funções de Sala
async function listarSalas() {
    return fetchData(API.salas);
}

async function criarSala(sala) {
    return fetchData(API.salas, {
        method: 'POST',
        body: JSON.stringify(sala)
    });
}

// Funções de Reserva
async function listarReservas() {
    return fetchData(API.reservas);
}

async function criarReserva(reserva) {
    return fetchData(API.reservas, {
        method: 'POST',
        body: JSON.stringify(reserva)
    });
} 