import React, { useEffect, useState } from "react";

import { Card, Table, Jumbotron } from "react-bootstrap";

interface Day {
  day: number;
  week: number;
  time: string;
  subject: string;
  type: string;
  teacher: string;
  place: string;
}

export function MyComponent() {
  const [error, setError] = useState<Error | null>(null);
  const [isLoaded, setIsLoaded] = useState(false);
  const [items, setItems] = useState<Day[]>([]);

  // Note: the empty deps array [] means
  // this useEffect will run once
  // similar to componentDidMount()
  useEffect(() => {
    fetch(
      "https://edu.sfu-kras.ru/api/timetable/get&target=%D0%9A%D0%9818-16%D0%B1"
    )
      .then((res) => res.json())
      .then((result) => {
        setIsLoaded(true);
        setItems(result.timetable);
      })
      .catch((error: Error) => {
        setIsLoaded(true);
        setError(error);
      });
  }, []);

  if (error) {
    return <div>Error: {error.message}</div>;
  } else if (!isLoaded) {
    return <div>Loading...</div>;
  } else {
    return (
      <Table striped bordered hover>
        <thead>
          <tr>
            <th>День</th>
            <th>Предмет</th>
            <th>Преподаватель</th>
          </tr>
        </thead>
        {items.map((item) => (
          <tr>
            <td>{item.day}</td>
            <td>{item.subject}</td>
            <td>{item.teacher}</td>
          </tr>
        ))}
      </Table>
    );
  }
}
