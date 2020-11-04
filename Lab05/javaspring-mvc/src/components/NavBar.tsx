import React from "react";
import { Navbar, Nav } from "react-bootstrap";
import { LinkContainer } from "react-router-bootstrap";

export const NavBar: React.FunctionComponent = () => {
  return (
    <Navbar bg="primary" variant="dark">
      <LinkContainer to="/">
        <Navbar.Brand>javaspring-mvc</Navbar.Brand>
      </LinkContainer>
      <Navbar.Collapse>
        <Nav>
          <LinkContainer to="./furnitures">
            <Nav.Link>Список всех</Nav.Link>
          </LinkContainer>
          <LinkContainer to="./furnitures-by-type">
            <Nav.Link>Список по типу</Nav.Link>
          </LinkContainer>
          <LinkContainer to="./add">
            <Nav.Link>Добавить</Nav.Link>
          </LinkContainer>
          <LinkContainer to="./update">
            <Nav.Link>Изменить</Nav.Link>
          </LinkContainer>
          <LinkContainer to="./delete">
            <Nav.Link>Удалить</Nav.Link>
          </LinkContainer>
        </Nav>
      </Navbar.Collapse>
    </Navbar>
  );
};
