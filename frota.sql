-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 09, 2017 at 10:05 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 7.1.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `frota`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `apagaFuncionario` (IN `id` INT(12))  NO SQL
delete from funcionario where idFun= id$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cargaValorSup` (IN `val` DECIMAL(10,2))  IF val < (SELECT max(c.Valor) FROM carga c) THEN 
	SELECT * from carga c WHERE c.Valor> val; 
ELSE 
	SELECT 'Nao existem cargas com valor superior a:',val; 
END IF$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `causaMulta` (IN `val` DECIMAL)  SELECT m.causa as Causa_Multa 
FROM multa m where m.valor>val$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `cmviagens` ()  select 'O condutor com mais viagens eh o Sr. :', dc.nome,dc.apelido, c.Anos_Experiencia,c.numViagens 
from dadoscondutor dc natural join condutormaisviagens NATURAL join condutor c$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `condutor_multa_grave` ()  SELECT dc.nome,dc.apelido, m.tipo_multa, m.Causa 
from multa m NATURAL join multa_viagem natural join condutor_camiao natural join dadoscondutor dc 
where m.tipo_multa='grave'$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `freguesP` ()  SELECT c.nome,c.provincia, max(DISTINCT(c.TotalSolicitacoes)) as quant_solicitacoes from cliente c 
GROUP by nome$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `funcionarios` (IN `c` VARCHAR(10))  NO SQL
SELECT * from funcionario WHERE categoria = c$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `mais30Anos` ()  SELECT nome,apelido,contacto,anos_experiencia,data_nasc 
from dadoscondutor d NATURAL join condutor c WHERE (CURRENT_DATE-data_nasc)>300000$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `nCamiao_Carga` (IN `codV` INT(4), IN `idC` INT(4), IN `matricula` INT(12), IN `dataa` VARCHAR(12))  NO SQL
INSERT INTO camiao_carga VALUES(codV,idC,matricula,dataa)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `nCliVi` (IN `idV` INT(6), `idc` INT(6), IN `custoV` DECIMAL(10,2))  begin
INSERT into cliente_viagem values(idV,idc,custoV);
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `newCaManut` (IN `codM` INT(5), IN `matric` VARCHAR(10), IN `dataa` VARCHAR(12), IN `custo` DECIMAL(10,2))  NO SQL
INSERT INTO camiao_manuntencao VALUES (codM,matric,dataa,custo)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `nMul_Via` (IN `idV` INT(6), IN `idF` INT(8), IN `matricula` VARCHAR(10), IN `eC` VARCHAR(20))  begin 
INSERT into condutor_camiao values(idV,idF,matricula,ec); 
end$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novaCarga` (IN `id` INT(4), IN `peso` DECIMAL(3,0), IN `seguro` VARCHAR(3), IN `tipo` VARCHAR(10), IN `valor` DECIMAL(10,2), IN `idC` INT(4))  NO SQL
INSERT into carga VALUES(id,peso,seguro,tipo,valor,idC)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novaManut` (IN `descr` VARCHAR(45), IN `tipo` VARCHAR(45))  NO SQL
INSERT INTO manuntencao VALUES (null,descr,tipo)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novaMulta` (IN `num` INT(11), IN `tmulta` VARCHAR(10), IN `causa` VARCHAR(50), IN `valor` DOUBLE)  NO SQL
INSERT into multa values(num,tmulta,causa,valor)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novaViagem` (IN `codV` INT(6), IN `pp` VARCHAR(15), IN `dist` FLOAT(4), IN `dataP` VARCHAR(12), IN `pm` VARCHAR(12), IN `provincia` VARCHAR(15), IN `distrito` VARCHAR(10), IN `cidade` VARCHAR(10))  NO SQL
insert INTO viagem values (codV,pp,dist,dataP,pm,provincia,distrito,cidade)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoCamiao` (IN `matricula` VARCHAR(12), IN `marca` VARCHAR(10), IN `tanque` VARCHAR(10), IN `seguros` VARCHAR(19), IN `peso_bruto` INT(8))  NO SQL
INSERT INTO camiao values(matricula,marca,tanque, seguros,peso_bruto,0,0)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoCliente` (IN `nome` VARCHAR(20), IN `provincia` VARCHAR(45), IN `Distrito` VARCHAR(45))  NO SQL
insert into cliente VALUES (null,nome,provincia,distrito,0,0)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoCondutor` (IN `idFun` INT(10), IN `anosExp` INT(2), IN `data_nasc` VARCHAR(15), IN `idgestor` INT(10))  NO SQL
INSERT into condutor values(idfun,anosExp,data_nasc,idGestor,null)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoContacto` (IN `id` INT(4), IN `numero` BIGINT(9), IN `chooser` INT(2))  NO SQL
if chooser=1 THEN
INSERT INTO telefonefun VALUES (id,numero);
ELSE 
INSERT into telefoneclient VALUES(id,numero);

end if$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoFuncionario` (IN `nome` VARCHAR(45), IN `apelido` VARCHAR(45), IN `salario` DECIMAL(20), IN `categoria` VARCHAR(1))  NO SQL
INSERT into funcionario values(null,nome,apelido,categoria,salario)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `novoGestor` (IN `idgestor` INT(10), IN `qualif` VARCHAR(45))  NO SQL
INSERT into gestor values(idgestor,qualif)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `viagemCustoSuperior` (IN `custoMin` DECIMAL)  IF custoMin< (SELECT max(c.custo_viagem) from dadosviagem c) THEN 
SELECT * from dadosviagem v WHERE v.custo_viagem> custoMin; 
ELSE 
SELECT 'Nao temos registada uma viagem com distancia superior a: ',distMin; 
END IF$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `viagemDistSuperior` ()  SELECT * from dadosviagem v WHERE v.distancia> 70$$

--
-- Functions
--
CREATE DEFINER=`root`@`localhost` FUNCTION `buscaCodManut` () RETURNS INT(11) NO SQL
RETURN (SELECT max(m.codManuntencao)  from manuntencao m)$$

CREATE DEFINER=`root`@`localhost` FUNCTION `buscaId` () RETURNS INT(11) NO SQL
RETURN (SELECT max(idFun) from funcionario)$$

CREATE DEFINER=`root`@`localhost` FUNCTION `buscaIdClient` () RETURNS INT(11) NO SQL
RETURN (SELECT max(c.idCliente) from cliente c )$$

CREATE DEFINER=`root`@`localhost` FUNCTION `buscaIdMaxViagem` () RETURNS INT(11) NO SQL
RETURN (SELECT max(v.codViagem) from viagem v)$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `camiao`
--

CREATE TABLE `camiao` (
  `Matricula` varchar(10) NOT NULL,
  `Marca` varchar(10) NOT NULL,
  `Tanque` decimal(4,0) NOT NULL,
  `Seguros` varchar(12) NOT NULL,
  `peso_bruto` int(5) NOT NULL,
  `Num_Viagens` int(10) NOT NULL DEFAULT '0',
  `Num_Manutencoes` int(12) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `camiao`
--

INSERT INTO `camiao` (`Matricula`, `Marca`, `Tanque`, `Seguros`, `peso_bruto`, `Num_Viagens`, `Num_Manutencoes`) VALUES
('AAA-010-MP', 'DAV', '800', 'COM', 14750, 2, 0),
('ACB-123-IB', 'MAN', '800', 'COM', 23600, 0, 0),
('ACF-541-MC', 'VALIANT', '800', 'COM', 25000, 0, 0),
('ACK-013-MC', 'IVEDO', '800', 'COM', 26000, 0, 1),
('ACR-345-GZ', 'IVEDO', '600', 'COM', 30000, 0, 0),
('ACR-763-MC', 'VALIANT', '150', 'COM', 26500, 1, 0),
('ACT-968-MC', 'VOLVO', '400', 'COM', 27000, 0, 1),
('AEK-230-MC', 'IVEDO', '500', 'Assegurado', 23000, 0, 0),
('MMQ-239-IB', 'IVEDO', '1000', 'SEM', 26000, 0, 0),
('MTU-987-TT', 'MAN', '700', 'SEM', 35000, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `camiao_carga`
--

CREATE TABLE `camiao_carga` (
  `codViagem` int(4) NOT NULL,
  `idCarga` int(4) NOT NULL,
  `matricula` varchar(10) NOT NULL,
  `data` varchar(12) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `camiao_carga`
--

INSERT INTO `camiao_carga` (`codViagem`, `idCarga`, `matricula`, `data`) VALUES
(201701, 12, 'ACR-763-MC', '2017-05-21'),
(201703, 13, 'AAA-010-MP', NULL),
(201704, 14, 'AAA-010-MP', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `camiao_manuntencao`
--

CREATE TABLE `camiao_manuntencao` (
  `codManuntencao` int(4) NOT NULL,
  `matricula` varchar(11) NOT NULL,
  `data_manuntencao` varchar(10) DEFAULT NULL,
  `custo_manuntencao` float NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `camiao_manuntencao`
--

INSERT INTO `camiao_manuntencao` (`codManuntencao`, `matricula`, `data_manuntencao`, `custo_manuntencao`) VALUES
(222, 'ACK-013-MC', '2017-05-03', 7500);

--
-- Triggers `camiao_manuntencao`
--
DELIMITER $$
CREATE TRIGGER `After_delete_camiao_manutencao` AFTER DELETE ON `camiao_manuntencao` FOR EACH ROW UPDATE camiao ca
    SET ca.Num_Manutencoes= ca.Num_Manutencoes -1
    WHERE ca.Matricula=old.matricula
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `After_insert_camiao_manutencao` AFTER INSERT ON `camiao_manuntencao` FOR EACH ROW UPDATE camiao ca
    set Num_Manutencoes = Num_Manutencoes+1
    WHERE ca.Matricula=new.matricula
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `After_update_camiao_manutencao` AFTER UPDATE ON `camiao_manuntencao` FOR EACH ROW IF new.matricula != old.matricula THEN
    UPDATE camiao c
       SET c.Num_Manutencoes=c.Num_Manutencoes-1
       WHERE c.Matricula=old.matricula;
    
    UPDATE camiao c 
       SET c.Num_Manutencoes=c.Num_Manutencoes+1
       WHERE c.Matricula=new.matricula;
END IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `carga`
--

CREATE TABLE `carga` (
  `idCarga` int(4) NOT NULL,
  `Peso` decimal(3,0) NOT NULL,
  `tipo` varchar(10) NOT NULL,
  `Valor` decimal(10,2) DEFAULT '0.00',
  `idCliente` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carga`
--

INSERT INTO `carga` (`idCarga`, `Peso`, `tipo`, `Valor`, `idCliente`) VALUES
(12, '32', 'Perecivel', '81000.00', 100),
(13, '35', 'Perecivel', '34000.00', 100),
(14, '55', 'Nao Pereci', '34000.00', 100);

-- --------------------------------------------------------

--
-- Table structure for table `categoria`
--

CREATE TABLE `categoria` (
  `categoria` varchar(1) NOT NULL,
  `totalFuncionarios` int(10) NOT NULL DEFAULT '0',
  `total salarios` int(11) NOT NULL DEFAULT '0',
  `media_salarios` decimal(15,0) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `categoria`
--

INSERT INTO `categoria` (`categoria`, `totalFuncionarios`, `total salarios`, `media_salarios`) VALUES
('A', 0, 0, '0'),
('B', 0, 0, '0'),
('c', 0, 0, '0'),
('D', 0, 0, '0');

-- --------------------------------------------------------

--
-- Table structure for table `cliente`
--

CREATE TABLE `cliente` (
  `idCliente` int(4) NOT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `provincia` varchar(10) NOT NULL,
  `distrito` varchar(10) NOT NULL,
  `TotalValor` int(20) NOT NULL DEFAULT '0',
  `TotalSolicitacoes` int(5) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente`
--

INSERT INTO `cliente` (`idCliente`, `nome`, `provincia`, `distrito`, `TotalValor`, `TotalSolicitacoes`) VALUES
(100, 'Mozal', 'Maputo', 'Matola', 123000, 2),
(101, 'MozArt', 'Nampula', '', 35000, 1),
(102, 'Buiders', 'Tete', '', 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `cliente_viagem`
--

CREATE TABLE `cliente_viagem` (
  `codViagem` int(4) NOT NULL,
  `idCliente` int(4) NOT NULL,
  `custo_viagem` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cliente_viagem`
--

INSERT INTO `cliente_viagem` (`codViagem`, `idCliente`, `custo_viagem`) VALUES
(201701, 100, 48000),
(201703, 100, 75000),
(201704, 101, 35000);

--
-- Triggers `cliente_viagem`
--
DELIMITER $$
CREATE TRIGGER `After_delete_cliente_viagem` AFTER DELETE ON `cliente_viagem` FOR EACH ROW UPDATE cliente cli
    SET cli.TotalSolicitacoes= cli.TotalSolicitacoes -1,         				cli.TotalValor=cli.TotalValor - old.custo_viagem 
    WHERE cli.idCliente=old.idCliente
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `After_insert_cliente_viagem` AFTER INSERT ON `cliente_viagem` FOR EACH ROW UPDATE cliente cli 
    set TotalSolicitacoes=TotalSolicitacoes + 1,         				cli.TotalValor=cli.TotalValor + new.custo_viagem 
    WHERE cli.idCliente=new.idCliente
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `After_update_cliente_viagem` AFTER UPDATE ON `cliente_viagem` FOR EACH ROW IF new.idCliente != old.idCliente THEN
     UPDATE cliente c 
        SET c.TotalSolicitacoes= c.TotalSolicitacoes -1, 
        c.TotalValor= TotalValor-old.custo_viagem
        WHERE c.idCliente = old.idCliente;
        
        UPDATE cliente c 
        SET c.TotalSolicitacoes= c.TotalSolicitacoes +1, 
        c.TotalValor= TotalValor+new.custo_viagem
        WHERE c.idCliente = new.idCliente;
 END IF
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `condutor`
--

CREATE TABLE `condutor` (
  `idFun` int(4) NOT NULL,
  `Anos_Experiencia` int(2) NOT NULL DEFAULT '0',
  `data_nasc` date NOT NULL,
  `numViagens` int(5) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `condutor`
--

INSERT INTO `condutor` (`idFun`, `Anos_Experiencia`, `data_nasc`, `numViagens`) VALUES
(114, 0, '1987-05-11', 2),
(115, 0, '1990-05-03', 1);

-- --------------------------------------------------------

--
-- Stand-in structure for view `condutormaisviagens`
-- (See below for the actual view)
--
CREATE TABLE `condutormaisviagens` (
`idFun` int(4)
,`max(numViagens)` int(5)
);

-- --------------------------------------------------------

--
-- Table structure for table `condutor_camiao`
--

CREATE TABLE `condutor_camiao` (
  `codViagem` int(4) NOT NULL,
  `idFun` int(4) NOT NULL,
  `matricula` varchar(11) NOT NULL,
  `estado_camiao` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `condutor_camiao`
--

INSERT INTO `condutor_camiao` (`codViagem`, `idFun`, `matricula`, `estado_camiao`) VALUES
(201701, 114, 'ACR-763-MC', 'nnnn'),
(201703, 115, 'AAA-010-MP', 'Razoavel'),
(201704, 114, 'AAA-010-MP', 'Razoavel');

--
-- Triggers `condutor_camiao`
--
DELIMITER $$
CREATE TRIGGER `After_delete_condutor_camiao` AFTER DELETE ON `condutor_camiao` FOR EACH ROW begin
UPDATE condutor c
   set numViagens=numViagens - 1
   
   WHERE c.idFun=old.idFun;

UPDATE camiao ca
   set ca.Num_Viagens=ca.Num_Viagens - 1
   
   WHERE ca.Matricula=old.matricula;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `After_insert_condutor_camiao` AFTER INSERT ON `condutor_camiao` FOR EACH ROW begin
UPDATE condutor c
   set numViagens=numViagens + 1
   
   WHERE c.idFun=new.idFun;

UPDATE camiao ca
   set ca.Num_Viagens=ca.Num_Viagens + 1
   
   WHERE ca.Matricula=new.matricula;
END
$$
DELIMITER ;
DELIMITER $$
CREATE TRIGGER `After_update_condutor_camiao` AFTER UPDATE ON `condutor_camiao` FOR EACH ROW BEGIN
	if new.idFun != old.idFun THEN
		UPDATE condutor c
  		 set numViagens=numViagens - 1
  		 WHERE c.idFun=old.idFun;
         
		UPDATE condutor c
   		 SET numViagens=numViagens + 1
  		 WHERE c.idFun=new.idFun;
	END IF;

	if new.matricula!=old.matricula THEN
		UPDATE camiao ca
   			SET ca.Num_Viagens=ca.Num_Viagens - 1
   			WHERE ca.Matricula=old.matricula;
            
		UPDATE camiao ca
  			SET ca.Num_Viagens=ca.Num_Viagens + 1
   			WHERE ca.Matricula=new.matricula;
	END IF; 
END
$$
DELIMITER ;

-- --------------------------------------------------------

--
-- Stand-in structure for view `dadoscondutor`
-- (See below for the actual view)
--
CREATE TABLE `dadoscondutor` (
`idFun` int(4)
,`nome` varchar(15)
,`apelido` varchar(10)
,`contacto` bigint(9)
,`numViagens` int(5)
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `dadosviagem`
-- (See below for the actual view)
--
CREATE TABLE `dadosviagem` (
`idCliente` int(4)
,`codViagem` int(7)
,`ponto_partida` varchar(20)
,`distancia` float
,`data_partida` varchar(12)
,`pocket_money` float
,`provincia` varchar(45)
,`distrito` varchar(10)
,`cidade` varchar(10)
,`idCarga` int(4)
,`tipo` varchar(10)
,`Valor` decimal(10,2)
,`custo_viagem` float
,`idFun` int(4)
,`matricula` varchar(11)
,`numero` int(11)
,`data_multa` date
);

-- --------------------------------------------------------

--
-- Table structure for table `funcionario`
--

CREATE TABLE `funcionario` (
  `idFun` int(4) NOT NULL,
  `nome` varchar(15) NOT NULL,
  `apelido` varchar(10) NOT NULL,
  `Categoria` varchar(1) DEFAULT NULL,
  `salario` decimal(20,0) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funcionario`
--

INSERT INTO `funcionario` (`idFun`, `nome`, `apelido`, `Categoria`, `salario`) VALUES
(114, 'David', 'Moises', 'C', '19500'),
(115, 'Julio', 'Dimas', 'D', '21000'),
(116, 'Quebra', 'Cumbe', 'A', '21000');

-- --------------------------------------------------------

--
-- Table structure for table `gestor`
--

CREATE TABLE `gestor` (
  `idGestor` int(4) NOT NULL,
  `qualificacoes` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Stand-in structure for view `hist_maanut`
-- (See below for the actual view)
--
CREATE TABLE `hist_maanut` (
`codManuntencao` int(4)
,`Marca` varchar(10)
,`Matricula` varchar(10)
,`descricao` varchar(50)
,`tipo` varchar(10)
,`custo` float
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `infocondutor`
-- (See below for the actual view)
--
CREATE TABLE `infocondutor` (
`idFun` int(4)
,`nome` varchar(15)
,`apelido` varchar(10)
,`Categoria` varchar(1)
,`salario` decimal(20,0)
,`Anos_Experiencia` int(2)
,`data_nasc` date
);

-- --------------------------------------------------------

--
-- Stand-in structure for view `listacondcomvianampula`
-- (See below for the actual view)
--
CREATE TABLE `listacondcomvianampula` (
`nome` varchar(15)
,`apelido` varchar(10)
,`contacto` bigint(9)
,`provincia` varchar(45)
);

-- --------------------------------------------------------

--
-- Table structure for table `manuntencao`
--

CREATE TABLE `manuntencao` (
  `codManuntencao` int(4) NOT NULL,
  `descricao` varchar(50) NOT NULL,
  `tipo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `manuntencao`
--

INSERT INTO `manuntencao` (`codManuntencao`, `descricao`, `tipo`) VALUES
(222, '', 'Preventiva');

-- --------------------------------------------------------

--
-- Table structure for table `multa`
--

CREATE TABLE `multa` (
  `numero` int(11) NOT NULL,
  `tipo_multa` varchar(10) NOT NULL,
  `Causa` varchar(50) NOT NULL,
  `valor` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `multa`
--

INSERT INTO `multa` (`numero`, `tipo_multa`, `Causa`, `valor`) VALUES
(1024, 'Media', 'Falar ao Telefone', 1500),
(1259, 'Grave', 'Excesso de velocidad', 1500);

-- --------------------------------------------------------

--
-- Table structure for table `multa_viagem`
--

CREATE TABLE `multa_viagem` (
  `codViagem` int(4) NOT NULL,
  `numero` int(11) NOT NULL,
  `data_multa` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `multa_viagem`
--

INSERT INTO `multa_viagem` (`codViagem`, `numero`, `data_multa`) VALUES
(201701, 1259, '2017-05-23');

-- --------------------------------------------------------

--
-- Table structure for table `telefoneclient`
--

CREATE TABLE `telefoneclient` (
  `idCliente` int(4) NOT NULL,
  `contacto` bigint(9) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `telefoneclient`
--

INSERT INTO `telefoneclient` (`idCliente`, `contacto`) VALUES
(100, 842582011),
(100, 862314789),
(100, 872311290);

-- --------------------------------------------------------

--
-- Table structure for table `telefonefun`
--

CREATE TABLE `telefonefun` (
  `idFun` int(4) NOT NULL,
  `contacto` bigint(9) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `telefonefun`
--

INSERT INTO `telefonefun` (`idFun`, `contacto`) VALUES
(114, 842180223);

-- --------------------------------------------------------

--
-- Table structure for table `viagem`
--

CREATE TABLE `viagem` (
  `codViagem` int(7) NOT NULL,
  `ponto_partida` varchar(20) NOT NULL,
  `distancia` float NOT NULL,
  `data_partida` varchar(12) NOT NULL,
  `pocket_money` float NOT NULL,
  `provincia` varchar(45) NOT NULL,
  `distrito` varchar(10) DEFAULT NULL,
  `cidade` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `viagem`
--

INSERT INTO `viagem` (`codViagem`, `ponto_partida`, `distancia`, `data_partida`, `pocket_money`, `provincia`, `distrito`, `cidade`) VALUES
(201701, 'Maputo', 1400, '2017-05-22', 1300, 'Nampula', 'Inhassunge', 'Quelimane'),
(201703, 'Maputo', 150, '2017-05-30', 1000, 'Gaza', NULL, NULL),
(201704, 'Maputo', 155, '2017-06-30', 1200, 'Zambezia', NULL, NULL);

-- --------------------------------------------------------

--
-- Stand-in structure for view `viagens_multadas`
-- (See below for the actual view)
--
CREATE TABLE `viagens_multadas` (
`codViagem` int(7)
,`distancia` float
,`provincia` varchar(45)
,`distrito` varchar(10)
,`cidade` varchar(10)
,`Causa` varchar(50)
,`Numero_Multa` int(11)
);

-- --------------------------------------------------------

--
-- Structure for view `condutormaisviagens`
--
DROP TABLE IF EXISTS `condutormaisviagens`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `condutormaisviagens`  AS  select `condutor`.`idFun` AS `idFun`,max(`condutor`.`numViagens`) AS `max(numViagens)` from `condutor` ;

-- --------------------------------------------------------

--
-- Structure for view `dadoscondutor`
--
DROP TABLE IF EXISTS `dadoscondutor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dadoscondutor`  AS  select `f`.`idFun` AS `idFun`,`f`.`nome` AS `nome`,`f`.`apelido` AS `apelido`,`t`.`contacto` AS `contacto`,`c`.`numViagens` AS `numViagens` from ((`funcionario` `f` join `condutor` `c` on((`f`.`idFun` = `c`.`idFun`))) left join `telefonefun` `t` on((`f`.`idFun` = `t`.`idFun`))) ;

-- --------------------------------------------------------

--
-- Structure for view `dadosviagem`
--
DROP TABLE IF EXISTS `dadosviagem`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `dadosviagem`  AS  select `cv`.`idCliente` AS `idCliente`,`v`.`codViagem` AS `codViagem`,`v`.`ponto_partida` AS `ponto_partida`,`v`.`distancia` AS `distancia`,`v`.`data_partida` AS `data_partida`,`v`.`pocket_money` AS `pocket_money`,`v`.`provincia` AS `provincia`,`v`.`distrito` AS `distrito`,`v`.`cidade` AS `cidade`,`ca`.`idCarga` AS `idCarga`,`ca`.`tipo` AS `tipo`,`ca`.`Valor` AS `Valor`,`cv`.`custo_viagem` AS `custo_viagem`,`cc`.`idFun` AS `idFun`,`cc`.`matricula` AS `matricula`,`mv`.`numero` AS `numero`,`mv`.`data_multa` AS `data_multa` from ((((`viagem` `v` join `cliente_viagem` `cv` on((`v`.`codViagem` = `cv`.`codViagem`))) join `carga` `ca` on((`cv`.`idCliente` = `ca`.`idCliente`))) join `condutor_camiao` `cc` on((`v`.`codViagem` = `cc`.`codViagem`))) left join `multa_viagem` `mv` on((`v`.`codViagem` = `mv`.`codViagem`))) ;

-- --------------------------------------------------------

--
-- Structure for view `hist_maanut`
--
DROP TABLE IF EXISTS `hist_maanut`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `hist_maanut`  AS  select `cm`.`codManuntencao` AS `codManuntencao`,`c`.`Marca` AS `Marca`,`c`.`Matricula` AS `Matricula`,`m`.`descricao` AS `descricao`,`m`.`tipo` AS `tipo`,`cm`.`custo_manuntencao` AS `custo` from ((`manuntencao` `m` join `camiao` `c`) join `camiao_manuntencao` `cm` on(((`m`.`codManuntencao` = `cm`.`codManuntencao`) and (`c`.`Matricula` = `cm`.`matricula`)))) ;

-- --------------------------------------------------------

--
-- Structure for view `infocondutor`
--
DROP TABLE IF EXISTS `infocondutor`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `infocondutor`  AS  select `d`.`idFun` AS `idFun`,`d`.`nome` AS `nome`,`d`.`apelido` AS `apelido`,`f`.`Categoria` AS `Categoria`,`f`.`salario` AS `salario`,`c`.`Anos_Experiencia` AS `Anos_Experiencia`,`c`.`data_nasc` AS `data_nasc` from ((`dadoscondutor` `d` join `condutor` `c` on(((`d`.`idFun` = `c`.`idFun`) and (`d`.`numViagens` = `c`.`numViagens`)))) join `funcionario` `f` on(((`d`.`idFun` = `f`.`idFun`) and (`d`.`nome` = `f`.`nome`) and (`d`.`apelido` = `f`.`apelido`)))) ;

-- --------------------------------------------------------

--
-- Structure for view `listacondcomvianampula`
--
DROP TABLE IF EXISTS `listacondcomvianampula`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `listacondcomvianampula`  AS  select `c`.`nome` AS `nome`,`c`.`apelido` AS `apelido`,`tf`.`contacto` AS `contacto`,`v`.`provincia` AS `provincia` from (((`viagem` `v` join `dadoscondutor` `c`) join `condutor_camiao` `cc`) join `telefonefun` `tf`) where ((`tf`.`idFun` = `c`.`idFun`) and (`v`.`provincia` = 'Nampula')) ;

-- --------------------------------------------------------

--
-- Structure for view `viagens_multadas`
--
DROP TABLE IF EXISTS `viagens_multadas`;

CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `viagens_multadas`  AS  select `v`.`codViagem` AS `codViagem`,`v`.`distancia` AS `distancia`,`v`.`provincia` AS `provincia`,`v`.`distrito` AS `distrito`,`v`.`cidade` AS `cidade`,`m`.`Causa` AS `Causa`,`m`.`numero` AS `Numero_Multa` from ((`viagem` `v` join `multa_viagem` `mv` on((`v`.`codViagem` = `mv`.`codViagem`))) join `multa` `m` on((`mv`.`numero` = `m`.`numero`))) ;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `camiao`
--
ALTER TABLE `camiao`
  ADD PRIMARY KEY (`Matricula`);

--
-- Indexes for table `camiao_carga`
--
ALTER TABLE `camiao_carga`
  ADD PRIMARY KEY (`codViagem`,`idCarga`,`matricula`),
  ADD UNIQUE KEY `idCarga` (`idCarga`),
  ADD KEY `fk_ccCamiao` (`matricula`);

--
-- Indexes for table `camiao_manuntencao`
--
ALTER TABLE `camiao_manuntencao`
  ADD PRIMARY KEY (`codManuntencao`,`matricula`),
  ADD KEY `fk_cmCamiao` (`matricula`);

--
-- Indexes for table `carga`
--
ALTER TABLE `carga`
  ADD PRIMARY KEY (`idCarga`),
  ADD KEY `gest_FK` (`idCliente`);

--
-- Indexes for table `categoria`
--
ALTER TABLE `categoria`
  ADD PRIMARY KEY (`categoria`);

--
-- Indexes for table `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indexes for table `cliente_viagem`
--
ALTER TABLE `cliente_viagem`
  ADD PRIMARY KEY (`codViagem`,`idCliente`),
  ADD KEY `fk_cvCliente` (`idCliente`);

--
-- Indexes for table `condutor`
--
ALTER TABLE `condutor`
  ADD PRIMARY KEY (`idFun`),
  ADD KEY `condutor_ibfk_1` (`Anos_Experiencia`);

--
-- Indexes for table `condutor_camiao`
--
ALTER TABLE `condutor_camiao`
  ADD PRIMARY KEY (`codViagem`,`idFun`,`matricula`),
  ADD KEY `fk_cocaCondutor` (`idFun`),
  ADD KEY `fk_cocaCamiao` (`matricula`);

--
-- Indexes for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD PRIMARY KEY (`idFun`),
  ADD KEY `fcat_fk` (`Categoria`);

--
-- Indexes for table `gestor`
--
ALTER TABLE `gestor`
  ADD PRIMARY KEY (`idGestor`);

--
-- Indexes for table `manuntencao`
--
ALTER TABLE `manuntencao`
  ADD PRIMARY KEY (`codManuntencao`);

--
-- Indexes for table `multa`
--
ALTER TABLE `multa`
  ADD PRIMARY KEY (`numero`),
  ADD UNIQUE KEY `numero` (`numero`);

--
-- Indexes for table `multa_viagem`
--
ALTER TABLE `multa_viagem`
  ADD PRIMARY KEY (`codViagem`,`numero`),
  ADD KEY `fk_mvMulta` (`numero`);

--
-- Indexes for table `telefoneclient`
--
ALTER TABLE `telefoneclient`
  ADD PRIMARY KEY (`idCliente`,`contacto`),
  ADD UNIQUE KEY `contacto` (`contacto`);

--
-- Indexes for table `telefonefun`
--
ALTER TABLE `telefonefun`
  ADD PRIMARY KEY (`idFun`,`contacto`),
  ADD UNIQUE KEY `contacto` (`contacto`);

--
-- Indexes for table `viagem`
--
ALTER TABLE `viagem`
  ADD PRIMARY KEY (`codViagem`),
  ADD UNIQUE KEY `codViagem` (`codViagem`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cliente`
--
ALTER TABLE `cliente`
  MODIFY `idCliente` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=103;
--
-- AUTO_INCREMENT for table `condutor`
--
ALTER TABLE `condutor`
  MODIFY `idFun` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=116;
--
-- AUTO_INCREMENT for table `funcionario`
--
ALTER TABLE `funcionario`
  MODIFY `idFun` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;
--
-- AUTO_INCREMENT for table `manuntencao`
--
ALTER TABLE `manuntencao`
  MODIFY `codManuntencao` int(4) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=223;
--
-- AUTO_INCREMENT for table `viagem`
--
ALTER TABLE `viagem`
  MODIFY `codViagem` int(7) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=201705;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `camiao_carga`
--
ALTER TABLE `camiao_carga`
  ADD CONSTRAINT `fk_ccCamiao` FOREIGN KEY (`matricula`) REFERENCES `condutor_camiao` (`matricula`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ccCarga` FOREIGN KEY (`idCarga`) REFERENCES `carga` (`idCarga`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_ccViag` FOREIGN KEY (`codViagem`) REFERENCES `viagem` (`codViagem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `camiao_manuntencao`
--
ALTER TABLE `camiao_manuntencao`
  ADD CONSTRAINT `fk_cmCamiao` FOREIGN KEY (`matricula`) REFERENCES `camiao` (`Matricula`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cmManut` FOREIGN KEY (`codManuntencao`) REFERENCES `manuntencao` (`codManuntencao`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `carga`
--
ALTER TABLE `carga`
  ADD CONSTRAINT `fk_ccli` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Constraints for table `cliente_viagem`
--
ALTER TABLE `cliente_viagem`
  ADD CONSTRAINT `fj_cvCli` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cvVia` FOREIGN KEY (`codViagem`) REFERENCES `viagem` (`codViagem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `condutor`
--
ALTER TABLE `condutor`
  ADD CONSTRAINT `fCondutor_fk` FOREIGN KEY (`idFun`) REFERENCES `funcionario` (`idFun`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `condutor_camiao`
--
ALTER TABLE `condutor_camiao`
  ADD CONSTRAINT `fk_cocaCamiao` FOREIGN KEY (`matricula`) REFERENCES `camiao` (`Matricula`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cocaCondutor` FOREIGN KEY (`idFun`) REFERENCES `condutor` (`idFun`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_cocaViag` FOREIGN KEY (`codViagem`) REFERENCES `viagem` (`codViagem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `funcionario`
--
ALTER TABLE `funcionario`
  ADD CONSTRAINT `fcat_fk` FOREIGN KEY (`Categoria`) REFERENCES `categoria` (`categoria`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Constraints for table `gestor`
--
ALTER TABLE `gestor`
  ADD CONSTRAINT `gf_fk` FOREIGN KEY (`idGestor`) REFERENCES `funcionario` (`idFun`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `multa_viagem`
--
ALTER TABLE `multa_viagem`
  ADD CONSTRAINT `fk_mvMulta` FOREIGN KEY (`numero`) REFERENCES `multa` (`numero`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_mvViag` FOREIGN KEY (`codViagem`) REFERENCES `viagem` (`codViagem`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `telefoneclient`
--
ALTER TABLE `telefoneclient`
  ADD CONSTRAINT `fk_tc` FOREIGN KEY (`idCliente`) REFERENCES `cliente` (`idCliente`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `telefonefun`
--
ALTER TABLE `telefonefun`
  ADD CONSTRAINT `tFuncionario_fk` FOREIGN KEY (`idFun`) REFERENCES `funcionario` (`idFun`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
