CREATE DATABASE ACADEMIA;

GO
USE ACADEMIA;

GO
CREATE TABLE PROFISSIONAL (
    CODIGO					INT				NOT NULL IDENTITY(1,1),
    NOME					VARCHAR(100)	NOT NULL,
    CPF						VARCHAR(11)		NOT NULL,
    RG						VARCHAR(9),
    EMAIL					VARCHAR(40)		NOT NULL,
	USUARIO					VARCHAR(30)		NOT NULL,
	SENHA					VARCHAR(20)		NOT NULL,
    DATA_NASCIMENTO			DATE			NOT NULL,
    CARGO					VARCHAR(30)		NOT NULL,
    ESCOLARIDADE			VARCHAR(100),
    DATA_CADASTRO			DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	DATA_ADMISSAO			DATE,
	DATA_DEMISSAO			DATE,
	CELULAR					VARCHAR(11),
	TELEFONE_RECADO			VARCHAR(11),
	TELEFONE_RESPONSAVEL	VARCHAR(10),
	LOGRADOURO				VARCHAR(100)	NOT NULL,
    NUMERO_CASA				INT				NOT NULL,
	COMPLEMENTO				VARCHAR(20),
    BAIRRO					VARCHAR(50)		NOT NULL,
    CIDADE					VARCHAR(100)	NOT NULL,
    UF						VARCHAR(2)		NOT NULL,
	STATUS					VARCHAR(1)		NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO')
    CONSTRAINT PK_PROFISSIONAL PRIMARY KEY (CODIGO),
	CONSTRAINT CK_PROFISSIONAL_STATUS CHECK(STATUS IN('A','I')),
	CONSTRAINT UQ_PROFISSIONAL_CPF UNIQUE(CPF),
);

GO
CREATE TABLE ALUNO (
    CODIGO					INT			NOT NULL IDENTITY(1,1),
	NOME_RESPONSAVEL		VARCHAR(100),
    NOME					VARCHAR(100)	NOT NULL,
    CPF						VARCHAR(11)		NOT NULL,
    RG						VARCHAR(9),
    EMAIL					VARCHAR(40)		NOT NULL,
	USUARIO					VARCHAR(30)		NOT NULL,
	SENHA					VARCHAR(20)		NOT NULL,
    DATA_NASCIMENTO			DATE			NOT NULL,
    CARGO					VARCHAR(30)		NOT NULL,
    DATA_CADASTRO			DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CELULAR					VARCHAR(11),
	TELEFONE_RECADO			VARCHAR(11),
	TELEFONE_RESPONSAVEL	VARCHAR(10),
	LOGRADOURO				VARCHAR(100)	NOT NULL,
    NUMERO_CASA				INT				NOT NULL,
	COMPLEMENTO				VARCHAR(20),
    BAIRRO					VARCHAR(50)		NOT NULL,
    CIDADE					VARCHAR(100)	NOT NULL,
    UF						VARCHAR(2)		NOT NULL,
	STATUS					VARCHAR(1)		NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO')
    CONSTRAINT PK_ALUNO PRIMARY KEY (CODIGO),
	CONSTRAINT CK_ALUNO_STATUS CHECK(STATUS IN('A','I')),
	CONSTRAINT UQ_PESSOA_CPF UNIQUE(CPF),
);

GO
CREATE TABLE SERIES_EXERCICIOS (
	CODIGO			INT			NOT NULL IDENTITY(1,1),
	SERIE_REPETICAO INT			NOT NULL,
	CARGA			INT,
	CARGA_MAXIMA	INT,
	OBSERVACAO		VARCHAR(100),
	STATUS			VARCHAR(1) NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO'),
	CONSTRAINT PK_SERIES_EXERCICIOS PRIMARY KEY (CODIGO),
	CONSTRAINT CK_SERIE_EXERCICIOS_STATUS CHECK(STATUS IN('A','I')),
);

GO
CREATE TABLE EXERCICIOS (
	CODIGO						INT			NOT NULL IDENTITY(1,1),
	CODIGO_SERIES_EXERCICIOS	INT			NOT NULL,
	DESCRICAO_EXERCICIOS		VARCHAR(100),
	STATUS						VARCHAR(1)	NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO'),
	CONSTRAINT PK_EXERCICIOS PRIMARY KEY (CODIGO),
	CONSTRAINT FK_EXERCICIOS_SERIES_EXERCICIOS FOREIGN KEY (CODIGO_SERIES_EXERCICIOS) REFERENCES SERIES_EXERCICIOS (CODIGO),
	CONSTRAINT CK_EXERCICIOS_STATUS CHECK(STATUS IN('A','I')),
);

GO
CREATE TABLE GRUPO_EXERCICIOS (
	CODIGO						INT			NOT NULL IDENTITY(1,1),
	CODIGO_EXERCICIOS			INT			NOT NULL,
	DESCRICAO_GRUPO_EXERCICIOS	VARCHAR(100),
	STATUS						VARCHAR(1) NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO'),
	CONSTRAINT PK_GRUPO_EXERCICIOS PRIMARY KEY (CODIGO),
	CONSTRAINT FK_GRUPO_EXERCICIOS_EXERCICIOS FOREIGN KEY (CODIGO_EXERCICIOS) REFERENCES EXERCICIOS (CODIGO),
	CONSTRAINT CK_GRUPO_EXERCICIOS_STATUS CHECK(STATUS IN('A','I')),
);

GO
CREATE TABLE MODALIDADE_HORARIO (
    CODIGO			INT				NOT NULL IDENTITY(1,1),
    DIA_SEMANA		VARCHAR(100)	NOT NULL,
    HORA_INICIO		TIME			NOT NULL,
    HORA_FIM		TIME			NOT NULL,
    DATA_CADASTRO	DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	STATUS			VARCHAR(1)		NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO')
    CONSTRAINT PK_MODALIDADE_HORARIO PRIMARY KEY (CODIGO),
	CONSTRAINT CK_MODALIDADE_HORARIO_STATUS CHECK(STATUS IN('A','I')),
);

GO
CREATE TABLE MODALIDADE (
    CODIGO						INT				NOT NULL IDENTITY(1,1),
	CODIGO_MODALIDADE_HORARIO	INT				NOT NULL,
	CODIGO_GRUPO_EXERCICIOS		INT				NOT NULL,
    NOME						VARCHAR(50)		NOT NULL,
    DESCRICAO					VARCHAR(100),
    VALOR						NUMERIC(19, 2)	NOT NULL,
    DATA_CADASTRO				DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
	STATUS						VARCHAR(1)		NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO')
    CONSTRAINT PK_MODALIDADE PRIMARY KEY (CODIGO),
	CONSTRAINT FK_MODALIDADE_MODALIDADE_HORARIO FOREIGN KEY (CODIGO_MODALIDADE_HORARIO) REFERENCES MODALIDADE_HORARIO (CODIGO),
	CONSTRAINT FK_MODALIDADE_GRUPO_EXERCICIOS FOREIGN KEY (CODIGO_GRUPO_EXERCICIOS) REFERENCES GRUPO_EXERCICIOS (CODIGO),
	CONSTRAINT CK_MODALIDADE_STATUS CHECK(STATUS IN('A','I')),
);

GO
CREATE TABLE MATRICULA (
    CODIGO				INT				NOT NULL IDENTITY(1,1),
    CODIGO_ALUNO		INT				NOT NULL,
    CODIGO_MODALIDADE	INT				NOT NULL,
	VALOR_TOTAL			NUMERIC(19, 2)	NOT NULL,
	DESCONTO			INT,
	DATA_INICIO			DATE			NOT NULL,
    DATA_MATRICULA		DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
    DATA_CANCELAMENTO	DATETIME,
	STATUS				VARCHAR(1)		NOT NULL DEFAULT 'A', -- ('ATIVO', 'INATIVO')
	MOTIVO_CANCELAMENTO	VARCHAR(100),
    CONSTRAINT PK_MATRICULA PRIMARY KEY (CODIGO),
    CONSTRAINT FK_MATRICULA_ALUNO FOREIGN KEY (CODIGO_ALUNO) REFERENCES ALUNO (CODIGO),
    CONSTRAINT FK_MATRICULA_MODALIDADE FOREIGN KEY (CODIGO_MODALIDADE) REFERENCES MODALIDADE (CODIGO),
	CONSTRAINT CK_MATRICULA_STATUS CHECK(STATUS IN('A','I')),
);

GO
CREATE TABLE HISTORICO_GERAL (
	CODIGO								INT			NOT NULL IDENTITY(1,1),
	CODIGO_ALUNO						INT			NOT NULL,
	CODIGO_PROFISSIONAL					INT			NOT NULL,
	CODIGO_MATRICULA					INT			NOT NULL,
	PRESAO_ALTA							CHAR(1),
	DIABETES							CHAR(1),
	DIFICULDADDE_RESPIRACAO				CHAR(1),
	PROBLEMA_CARDIACO					CHAR(1),
	LESAO_MUSCULAR						CHAR(1),
	FRATURA								CHAR(1),
	DOR_COSTAS							CHAR(1),
	ESCOLIOSE							CHAR(1),
	LORDOSE								CHAR(1),
	CIFOSE								CHAR(1),
	DESMAIOS							CHAR(1),
	DOR_PEITO							CHAR(1),
	ARITMIA_CARDIACA					CHAR(1),
	CAIMBRAS_CONSTANTES					CHAR(1),
	FADIGA								CHAR(1),
	INSONIA								CHAR(1),
	ANSIEDADE							CHAR(1),
	DEPRESS�O							CHAR(1),
	MEDICAMENTOS_REGULARES				CHAR(100)	NOT NULL,
	DESCRICAO_MEDICAMENTOS_REGULARES	CHAR(1),
	DORES_ARTICULARES					CHAR(1),
	DESCRICAO_DORES_ARTICULARES			CHAR(1),
	DOR_JOELHOS							CHAR(1),
	GRAU_INICANTE						CHAR(20),
	ANOTACOES_GERAIS_HISTORICO_GERAL	VARCHAR(100),
	DATA_CADASTRO						DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	CONSTRAINT PK_HISTORICO_GERAL PRIMARY KEY (CODIGO),
	CONSTRAINT FK_HISTORICO_GERAL_ALUNO FOREIGN KEY (CODIGO_ALUNO) REFERENCES ALUNO (CODIGO),
	CONSTRAINT FK_HISTORICO_GERAL_PROFISSIONAL FOREIGN KEY (CODIGO_PROFISSIONAL) REFERENCES PROFISSIONAL (CODIGO),
	CONSTRAINT FK_HISTORICO_GERAL_MATRICULA FOREIGN KEY (CODIGO_MATRICULA) REFERENCES MATRICULA (CODIGO),
);

GO
CREATE TABLE FICHA_AVALIACAO (
    CODIGO									INT         NOT NULL IDENTITY(1,1),
	CODIGO_HISTORICO_GERAL					INT			NOT NULL,
    CODIGO_ALUNO							INT         NOT NULL,
	CODIGO_PROFISSIONAL						INT			NOT NULL,
    PESO									FLOAT		NOT NULL,
    ALTURA									FLOAT		NOT NULL,
	PEITO									FLOAT,
	CINTURA									FLOAT,
	QUADRIL									FLOAT,
	BRACO_DIREITO							FLOAT,
	BRACO_ESQUERDO							FLOAT,
	COXA_DIREITA							FLOAT,
	COXA_ESQUERDA							FLOAT,
	GEMEOS_DIREITO							FLOAT,
	GEMEOS_ESQUERDO							FLOAT,
	ANTEBRACO_DIREITO						FLOAT,
	ANTEBRACO_ESQUERDO						FLOAT,
	ABDOMEN									FLOAT,
	DOBRA_CUTANEA							FLOAT,
	IMC										FLOAT		NOT NULL,
	HIPERTROFIA								CHAR(1),
	CONDICIONAL								CHAR(1),
	DEFINICAO								CHAR(1),
	REDUCAO									CHAR(1),
	DESCRICAO_OBJETIVO						VARCHAR(100),
	ANOTACOES_GERAIS_FICHA_AVALIACAO		VARCHAR(100),
	DATA_CADASTRO							DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_FICHA_AVALIACAO PRIMARY KEY (CODIGO),
	CONSTRAINT FK_FICHA_AVALIACAO_HISTORICO_GERAL FOREIGN KEY (CODIGO_HISTORICO_GERAL) REFERENCES HISTORICO_GERAL (CODIGO),
    CONSTRAINT FK_FICHA_AVALIACAO_ALUNO FOREIGN KEY (CODIGO_ALUNO) REFERENCES ALUNO (CODIGO),
	CONSTRAINT FK_FICHA_AVALIACAO_PROFISSIONAL FOREIGN KEY (CODIGO_PROFISSIONAL) REFERENCES PROFISSIONAL (CODIGO),
);

GO
CREATE TABLE FICHA_TREINO (
    CODIGO							INT			NOT NULL IDENTITY(1,1),
	CODIGO_GRUPO_EXERCICIOS			INT			NOT NULL,
    CODIGO_MATRICULA				INT			NOT NULL,
	CODIGO_PROFISSIONAL				INT			NOT NULL,
	NUMERO_FICHA					INT			NOT NULL,
    DATA_CADASTRO					DATETIME	NOT NULL DEFAULT CURRENT_TIMESTAMP,
	ANOTACOES_GERAIS_FICHA_TREINO	VARCHAR(100),
    CONSTRAINT PK_FICHA_TREINO PRIMARY KEY (CODIGO),
	CONSTRAINT FK_FICHA_TREINO_GRUPO_EXERCICIOS FOREIGN KEY (CODIGO_GRUPO_EXERCICIOS) REFERENCES GRUPO_EXERCICIOS (CODIGO),
    CONSTRAINT FK_FICHA_TREINO_MATRICULA FOREIGN KEY (CODIGO_MATRICULA) REFERENCES MATRICULA (CODIGO),
	CONSTRAINT FK_FICHA_TREINO_PROFISSIONAL FOREIGN KEY (CODIGO_PROFISSIONAL) REFERENCES PROFISSIONAL (CODIGO),
);

GO
CREATE TABLE GERAR_VENCIMENTOS (
    CODIGO				INT				NOT NULL IDENTITY(1,1),
	CODIGO_MATRICULA	INT				NOT NULL,
    CODIGO_BARRAS       INT				NOT NULL,
    VALOR				NUMERIC(19, 2)	NOT NULL,
    VALOR_MULTA			NUMERIC(19, 2)	NOT NULL,
	JUROS_VENCIMENTO	INT,
    DATA_VENCIMENTO		DATE			NOT NULL,
    DATA_CADASTRO		DATETIME		NOT NULL DEFAULT CURRENT_TIMESTAMP,
    STATUS				CHAR(1)	--('PAGA', 'NAO_PAGA', 'CANCELADA'),
    CONSTRAINT PK_GERAR_VENCIMENTOS PRIMARY KEY (CODIGO),
	CONSTRAINT FK_GERAR_VENCIMENTOS_MATRICULA FOREIGN KEY (CODIGO_MATRICULA) REFERENCES MATRICULA (CODIGO),
);
