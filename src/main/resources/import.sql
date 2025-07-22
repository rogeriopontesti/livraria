INSERT INTO autores (id, nome) VALUES ('d1a3df01-bb2f-4d70-9d9b-a111fa663f02', 'Machado de Assis');
INSERT INTO autores (id, nome) VALUES ('5b1d72a9-43a4-4e4c-9e17-3e9f17e489e9', 'Clarice Lispector');
INSERT INTO editoras (id, nome) VALUES ('e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf', 'Companhia das Letras');
INSERT INTO editoras (id, nome) VALUES ('f2c24d5b-70b8-4bc7-9a0b-730e8d539f91', 'Editora Globo');
INSERT INTO livros (id, titulo, editora_id)  VALUES ('aaa111bb-222c-433d-844e-555fff666111', 'Dom Casmurro', 'e4a3ad31-bf6f-42a5-a66e-4e2b8453a2cf');
INSERT INTO livro_autores (livro_id, autor_id)  VALUES ('aaa111bb-222c-433d-844e-555fff666111', 'd1a3df01-bb2f-4d70-9d9b-a111fa663f02');
INSERT INTO resenhas (id, resenha, livro_id)  VALUES ('1e234567-aaaa-bbbb-cccc-12345678eeee', 'Uma obra-prima da literatura brasileira.', 'aaa111bb-222c-433d-844e-555fff666111');