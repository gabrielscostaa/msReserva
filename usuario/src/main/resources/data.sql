INSERT INTO usuarios (nome, email, cpf, data_nascimento)
VALUES 
    ('João Silva', 'joao.silva@email.com', '12345678901', '1990-01-01'),
    ('Maria Santos', 'maria.santos@email.com', '98765432109', '1992-05-15'),
    ('Pedro Oliveira', 'pedro.oliveira@email.com', '45678912345', '1988-11-30')
ON CONFLICT (email, cpf) DO NOTHING;