const UI = {
    // Elementos do DOM
    elements: {
        usuariosList: document.getElementById('usuariosList'),
        salasList: document.getElementById('salasList'),
        reservasList: document.getElementById('reservasList'),
        toast: document.getElementById('toast')
    },

    // Funções de renderização
    renderUsuario(usuario) {
        return `
            <tr>
                <td>${usuario.nome}</td>
                <td>${usuario.email}</td>
                <td>${new Date(usuario.dataNascimento).toLocaleDateString()}</td>
            </tr>
        `;
    },

    renderSala(sala) {
        return `
            <tr>
                <td>${sala.nome}</td>
                <td>${sala.capacidade}</td>
            </tr>
        `;
    },

    renderReserva(reserva) {
        return `
            <tr>
                <td>${reserva.usuarioId}</td>
                <td>${reserva.salaId}</td>
                <td>${new Date(reserva.dataHora).toLocaleString()}</td>
            </tr>
        `;
    },

    // Funções de atualização de listas
    atualizarListaUsuarios(usuarios) {
        const container = document.getElementById('usuariosListContainer');
        if (!usuarios || usuarios.length === 0) {
            container.innerHTML = '<p class="empty-state">Nenhum usuário cadastrado</p>';
            return;
        }
        container.innerHTML = `
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Email</th>
                        <th>Data de Nascimento</th>
                    </tr>
                </thead>
                <tbody>
                    ${usuarios.map(this.renderUsuario).join('')}
                </tbody>
            </table>
        `;
    },

    atualizarListaSalas(salas) {
        const container = document.getElementById('salasListContainer');
        if (!salas || salas.length === 0) {
            container.innerHTML = '<p class="empty-state">Nenhuma sala cadastrada</p>';
            return;
        }
        container.innerHTML = `
            <table>
                <thead>
                    <tr>
                        <th>Nome</th>
                        <th>Capacidade</th>
                    </tr>
                </thead>
                <tbody>
                    ${salas.map(this.renderSala).join('')}
                </tbody>
            </table>
        `;
    },

    atualizarListaReservas(reservas) {
        const container = document.getElementById('reservasListContainer');
        if (!reservas || reservas.length === 0) {
            container.innerHTML = '<p class="empty-state">Nenhuma reserva cadastrada</p>';
            return;
        }
        container.innerHTML = `
            <table>
                <thead>
                    <tr>
                        <th>Usuário ID</th>
                        <th>Sala ID</th>
                        <th>Data/Hora</th>
                    </tr>
                </thead>
                <tbody>
                    ${reservas.map(this.renderReserva).join('')}
                </tbody>
            </table>
        `;
    },

    // Funções de formulário
    getFormData(formId) {
        const form = document.getElementById(formId);
        const formData = new FormData(form);
        const data = {};
        for (let [key, value] of formData.entries()) {
            data[key] = value;
        }
        form.reset();
        return data;
    },

    // Funções de notificação
    showToast(message, type = 'success') {
        const toast = document.getElementById('toast');
        toast.textContent = message;
        toast.className = `toast ${type}`;
        toast.style.display = 'block';
        
        setTimeout(() => {
            toast.style.display = 'none';
        }, 3000);
    }
}; 