import React from 'react';
import { Link } from 'react-router-dom';
import './LeftBar.css';
import im1 from '../../images/title_im.png';
import Card from "../Card/Card";

function LeftBar(props) {

  const data = {
    id: props.featuredCard.id,
    photo_link: props.featuredCard.photo_link,
    title: props.featuredCard.title,
    text: props.featuredCard.text,
    desc: props.featuredCard.desc,
    price: props.featuredCard.price,
    prePrice: props.featuredCard.prePrice,
    days: props.featuredCard.days,
    category: props.featuredCard.category,
    information: props.featuredCard.information,
    owner: props.featuredCard.owner
  }

  function handleClick() {
    props.handleClick(data);
  }

  return (
    <div className='left'>
      <p className='left__title'>Featured project</p>
      <div className='border'>
        <Link to={`/project/${props.featuredCard.id}`} onClick={handleClick}>
          <img src={props.featuredCard.photo_link} alt="" className='left__photo' />
        </Link>
      </div>
      <Link className='left__text' to={`/project/${props.featuredCard.id}`} onClick={handleClick}>
        <p className='left__text'>{props.featuredCard.title}</p>
      </Link>
      <p className='left__span'>{props.featuredCard.text}</p>
    </div>
  );
}

export default LeftBar;