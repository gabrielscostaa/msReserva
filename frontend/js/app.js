const App = {
    async init() {
        await this.carregarDados();
        this.setupEventListeners();
    },

    async carregarDados() {
        try {
            console.log('Carregando dados...');
            const [usuarios, salas, reservas] = await Promise.all([
                listarUsuarios(),
                listarSalas(),
                listarReservas()
            ]);

            console.log('Usuários carregados:', usuarios);
            console.log('Salas carregadas:', salas);
            console.log('Reservas carregadas:', reservas);

            if (usuarios) UI.atualizarListaUsuarios(usuarios);
            if (salas) UI.atualizarListaSalas(salas);
            if (reservas) UI.atualizarListaReservas(reservas);
        } catch (error) {
            console.error('Erro ao carregar dados:', error);
            UI.showToast('Erro ao carregar dados', 'error');
        }
    },

    setupEventListeners() {
        // Formulário de Usuário
        document.getElementById('usuarioForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const form = e.target;
            const nome = form.querySelector('#nomeUsuario').value.trim();
            const email = form.querySelector('#emailUsuario').value.trim();
            const dataNascimento = form.querySelector('#dataNascimentoUsuario').value;

            if (!nome || !email || !dataNascimento) {
                UI.showToast('Por favor, preencha todos os campos', 'error');
                return;
            }

            const usuario = { nome, email, dataNascimento };
            console.log('Criando usuário:', usuario);
            await this.criarUsuario(usuario);
        });

        // Formulário de Sala
        document.getElementById('salaForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const form = e.target;
            const nome = form.querySelector('#nomeSala').value.trim();
            const capacidade = form.querySelector('#capacidadeSala').value.trim();

            if (!nome || !capacidade) {
                UI.showToast('Por favor, preencha todos os campos', 'error');
                return;
            }

            const sala = { nome, capacidade: parseInt(capacidade) };
            console.log('Criando sala:', sala);
            await this.criarSala(sala);
        });

        // Formulário de Reserva
        document.getElementById('reservaForm').addEventListener('submit', async (e) => {
            e.preventDefault();
            const form = e.target;
            const usuarioId = form.querySelector('#usuarioId').value.trim();
            const salaId = form.querySelector('#salaId').value.trim();
            const dataHora = form.querySelector('#dataHoraReserva').value;

            if (!usuarioId || !salaId || !dataHora) {
                UI.showToast('Por favor, preencha todos os campos', 'error');
                return;
            }

            const reserva = {
                usuarioId: parseInt(usuarioId),
                salaId: parseInt(salaId),
                dataHora: new Date(dataHora).toISOString()
            };
            console.log('Criando reserva:', reserva);
            await this.criarReserva(reserva);
        });
    },

    // Funções de Usuário
    async criarUsuario(usuario) {
        try {
            console.log('Enviando requisição para criar usuário:', usuario);
            const novoUsuario = await criarUsuario(usuario);
            console.log('Resposta da criação de usuário:', novoUsuario);
            
            if (novoUsuario) {
                UI.showToast('Usuário criado com sucesso!');
                // Recarrega os dados após criar o usuário
                await this.carregarDados();
            }
        } catch (error) {
            console.error('Erro ao criar usuário:', error);
            UI.showToast('Erro ao criar usuário', 'error');
        }
    },

    // Funções de Sala
    async criarSala(sala) {
        try {
            console.log('Enviando requisição para criar sala:', sala);
            const novaSala = await criarSala(sala);
            console.log('Resposta da criação de sala:', novaSala);
            
            if (novaSala) {
                UI.showToast('Sala criada com sucesso!');
                await this.carregarDados();
            }
        } catch (error) {
            console.error('Erro ao criar sala:', error);
            UI.showToast('Erro ao criar sala', 'error');
        }
    },

    // Funções de Reserva
    async criarReserva(reserva) {
        try {
            console.log('Enviando requisição para criar reserva:', reserva);
            const novaReserva = await criarReserva(reserva);
            console.log('Resposta da criação de reserva:', novaReserva);
            
            if (novaReserva) {
                UI.showToast('Reserva criada com sucesso!');
                await this.carregarDados();
            }
        } catch (error) {
            console.error('Erro ao criar reserva:', error);
            UI.showToast('Erro ao criar reserva', 'error');
        }
    }
};

// Inicializar a aplicação quando o DOM estiver carregado
document.addEventListener('DOMContentLoaded', () => App.init()); 