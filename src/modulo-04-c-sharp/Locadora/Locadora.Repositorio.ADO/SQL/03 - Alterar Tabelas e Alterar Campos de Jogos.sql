begin transaction
CREATE TABLE dbo.Selo
(
	ID INT NOT NULL CONSTRAINT PK_IdSelo PRIMARY KEY Identity,
	Nome varchar(10) NOT NULL
)
ALTER TABLE DBO.Jogo ADD 
	Descricao varchar(MAX), 
	Imagem varchar(MAX), 
	Video varchar(MAX), 	
	IdSelo int constraint FK_IdSelo FOREIGN KEY REFERENCES Selo(ID)
commit

insert into Selo values ('ouro')
insert into Selo values ('prata')
insert into Selo values ('bronze')

update jogo set IdSelo=1

update dbo.Jogo SET Descricao ='Chrono Trigger' where ID = 1
update dbo.Jogo SET Descricao = 'Top Gear'  where ID =2
update dbo.Jogo SET Descricao = 'Megaman X'  where ID =3 
update dbo.Jogo SET Descricao = 'Super Metroid'  where ID =4 
update dbo.Jogo SET Descricao ='Donkey Kong Country'  where ID = 5
update dbo.Jogo SET Descricao =('Super Mario Kart')  where ID = 6
update dbo.Jogo SET Descricao =('Super Street Fighter')  where ID = 7
update dbo.Jogo SET Descricao =('Mortal Kombat 2')  where ID = 8
update dbo.Jogo SET Descricao =('Killer Instinct')  where ID = 9
update dbo.Jogo SET Descricao =('Final Fight')  where ID = 10
update dbo.Jogo SET Descricao =('Super Mario 1')  where ID = 11
update dbo.Jogo SET Descricao =('Aladdin')  where ID = 12
update dbo.Jogo SET Descricao =('Rock ''n Roll Racing')  where ID = 13
update dbo.Jogo SET Descricao =('Zelda: A link to the past')  where ID = 14
update dbo.Jogo SET Descricao =('Final Fantasy VI') where ID = 15
update dbo.Jogo SET Descricao =('International Super Star Soccer Deluxe') where ID = 16
update dbo.Jogo SET Descricao =('Contra III') where ID = 17
update dbo.Jogo SET Descricao =('Sunset Riders') where ID =18
update dbo.Jogo SET Descricao =('Goof Troop') where id= 19
update dbo.Jogo SET Descricao =('Mickey to Donald: Magical Adventure 3') where ID = 20

alter table jogo alter column idSelo int not null

alter table jogo alter column Descricao varchar(MAX) not null