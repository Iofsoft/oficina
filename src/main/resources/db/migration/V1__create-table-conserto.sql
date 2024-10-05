CREATE TABLE conserto (
                          id BIGINT AUTO_INCREMENT PRIMARY KEY,
                          data_entrada VARCHAR(255),
                          data_saida VARCHAR(255),

    -- Campos da classe Mecanico
                          nome VARCHAR(255),
                          experiencia INT,

    -- Campos da classe Veiculo
                          marca VARCHAR(255),
                          modelo VARCHAR(255),
                          ano VARCHAR(255)
);
