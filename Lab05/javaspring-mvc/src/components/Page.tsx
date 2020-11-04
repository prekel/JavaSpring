import React from "react";
import { BrowserRouter as Router } from "react-router-dom";
import { NavBar } from "./NavBar";
import { MainSwitch } from "./MainSwitch";
import { Container } from "react-bootstrap";

export const Page: React.FunctionComponent = () => {
  return (
    <Router basename="JavaSpring">
      <Container>
        <NavBar />

        <MainSwitch />
      </Container>
    </Router>
  );
};
