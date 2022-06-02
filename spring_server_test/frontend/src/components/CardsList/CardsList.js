import React from 'react';
import './CardsList.css';
import Card from '../Card/Card.js';

const CardsList = (props) => {
  return (
    <div className='listt'>
      <div className='listt__content'>
        <p className='listt__title'>{props.title}</p>
        <div className='listt__cards'>
          {
            props.articles.map((card) => {
              if (props.title === null || card.category.toLowerCase() === props.title.toLowerCase())
                return <Card
                  key={card.id}
                  id={card.id}
                  photo_link={card.photo_link}
                  title={card.title}
                  text={card.text}
                  desc={card.desc}
                  price={card.price}
                  prePrice={card.prePrice}
                  days={card.days}
                  category={card.category}
                  information={card.information}
                  isBlue={props.isBlue}
                  handleClick={props.handleClick}
                  owner={card.owner}
                />
              else return null
            })
          }
        </div>
      </div>
    </div>
  );
}

export default CardsList;